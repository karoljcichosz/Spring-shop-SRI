package pl.karolcichosz.sri.test;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("testBean")
public class TestBean implements Serializable {

//	@Inject
//	private CategoryDao catService;
	
	public TestBean() {
	}
	
	public void test() {
//		List<Category> listAll = catService.listAll(null, null);
//		System.out.println(listAll);
	}

}
