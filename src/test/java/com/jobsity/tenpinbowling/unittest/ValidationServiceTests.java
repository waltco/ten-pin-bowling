package com.jobsity.tenpinbowling;

import com.jobsity.tenpinbowling.model.Frame;
import com.jobsity.tenpinbowling.model.Line;
import com.jobsity.tenpinbowling.model.Player;
import com.jobsity.tenpinbowling.model.Result;
import com.jobsity.tenpinbowling.service.ValidationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ValidationServiceTests {

	@Autowired
	ValidationService validationService;



 

	@Test
	void Is_Lines_Invalid_Should_Return_False_When_Valid_Values() {
		List<Line> lines= Arrays.asList(
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10")
		);

		assertFalse(validationService.isLinesInvalid(lines));
	}

	@Test
	void Is_Lines_Invalid_Should_Return_False_When_Valid_Values_With_Foul() {
		List<Line> lines= Arrays.asList(
				new Line("George", "F"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10")
		);

		assertFalse(validationService.isLinesInvalid(lines));
	}

	@Test
	void Is_Lines_Invalid_Should_Return_True_When_Invalid_Values_X_As_Value() {
		List<Line> lines= Arrays.asList(
				new Line("George", "X"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10"),
				new Line("George", "10")
		);

		assertTrue(validationService.isLinesInvalid(lines));
	}



}
