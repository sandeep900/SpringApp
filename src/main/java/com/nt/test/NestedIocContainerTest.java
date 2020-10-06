package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.businessbeansConfig;
import com.nt.config.presentationbeansConfig;
import com.nt.control.MainControl;
import com.nt.dto.Employeedto;

public class NestedIocContainerTest {

	public static void main(String[] args) {

		List<Employeedto> listdto = null;

		/*
		 * //create parent Ioc container ApplicationContext parentctx=new
		 * ClassPathXmlApplicationContext("com/nt/cfg/businessbeans.xml"); //create
		 * child Ioc container ApplicationContext childctx=new
		 * ClassPathXmlApplicationContext(new String[]
		 * {"com/nt/cfg/Presentationbean.xml"},parentctx);
		 */

		AnnotationConfigApplicationContext parentctx = null, childctx = null;
		
		  parentctx=new AnnotationConfigApplicationContext(businessbeansConfig.class);
		  childctx=new AnnotationConfigApplicationContext(presentationbeansConfig.class);
		  childctx.setParent(parentctx);
		  
		 

		/*
		 * parentctx = new
		 * AnnotationConfigApplicationContext(businessbeansConfig.class); childctx = new
		 * AnnotationConfigApplicationContext(); childctx.setParent(parentctx);
		 * childctx.register(presentationbeansConfig.class); childctx.refresh();
		 */

		MainControl control = childctx.getBean("control", MainControl.class);
		System.out.println("---------------");
		try {
			listdto = control.gatherEmpsbyDesg("clerk", "manager", "salesman");

			/*
			 * for(Employeedto dto : listdto) { System.out.println(dto); }
			 */

			// java 8 feature + lamda expression
			listdto.forEach(dto -> {
				System.out.println(dto);
			});

			// java 8 feature + mwthod reference
			System.out.println("method reference");
			listdto.forEach(System.out::println);

			// System.out.println(listdto.isEmpty());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// close containers
		((AbstractApplicationContext) parentctx).close();
		((AbstractApplicationContext) childctx).close();

	}

}
