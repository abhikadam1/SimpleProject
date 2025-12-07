package com.example.SimpleProject.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ComprehensiveAspect {

    private static final Logger logger = LoggerFactory.getLogger(ComprehensiveAspect.class);

    // --- Define a single Pointcut Expression for reuse ---
//    @Pointcut("execution(* com.example.SimpleProject.Controller.*.*(..))")
    @Pointcut("execution(* com.example.SimpleProject.Controller.*.*(..))")
    public void serviceMethods() {}

    // 1. @Before Advice
    @Before("serviceMethods()")
//    @Before("execution (public * com.example.SimpleProject.Controller.ProductController.getProducts())")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("\n🟢 @Before: Executing method: {}. Input Args: {}", methodName, args);
    }

    // 2. @AfterReturning Advice
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("\n✅ @AfterReturning: Method {} returned successfully. Result: {}", methodName, result);
    }

    // 3. @AfterThrowing Advice
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("\n❌ @AfterThrowing: Method {} threw exception: {}", methodName, ex.getMessage());
    }

    // 4. @After (Finally) Advice
    @After("serviceMethods()")
    public void afterFinallyAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        // This runs whether the method succeeded or failed. Good for cleanup.
        logger.warn("\n🧹 @After (Finally): Method {} execution completed (Success or Exception).", methodName);
    }

    // 5. @Around Advice (The most comprehensive)
    @Around("serviceMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();

        logger.info("\n⏱️ @Around (Before): Starting timer for method: {}", methodName);

        Object result;
        try {
            // Execute the actual method
            result = joinPoint.proceed();
        } catch (Throwable t) {
            logger.error("\n⚠️ @Around (Exception): Method {} failed. Re-throwing exception.", methodName);
            throw t;
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(" in the end of world");
        logger.info("\n🏁 @Around (After): Method {} finished in {}ms.", methodName, duration);

        return result;
    }
}