package com.jobsity.tenpinbowling.unittest;

import com.jobsity.tenpinbowling.model.Line;
import com.jobsity.tenpinbowling.service.ValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
