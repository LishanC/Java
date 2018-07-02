import java.lang.annotation.*;

    @Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)

    public @interface ProperLength{
    	
    	int minLength() default 1;
  	    int maxLength() default 255;
     	
    }
