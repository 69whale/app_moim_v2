package org.edupoll.controller.api;

import org.edupoll.model.dto.response.TestResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //전부 ResponseBody가 적용됨 //뷰로 넘길수 없음 //무조건 return
@RequestMapping("/api")
public class TestTwoController {
	
	@GetMapping("/test-1")
	public TestResponseData testZHandle() {
		TestResponseData trd = new TestResponseData(3, "블라블라", null);
		return trd;
	}
	
	@GetMapping("/test-2")
	public String test2Handle() {
		return "moims/create";
	}

}
