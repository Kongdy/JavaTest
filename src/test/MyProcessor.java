package test;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

public class MyProcessor extends AbstractProcessor {

	
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		System.out.println("start.........................");
	}
	
	@Override
	public boolean process(Set<? extends TypeElement> elements,
			RoundEnvironment env) {
		System.out.println("aaaaaaaaaaaa");
		for(TypeElement t : elements) {
			System.out.println("name:"+t.getSimpleName());
		}
		
	    return true;
	}

}
