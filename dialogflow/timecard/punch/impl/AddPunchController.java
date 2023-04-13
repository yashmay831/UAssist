package com.dialogflow.timecard.punch.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class AddPunchController {

	@Autowired
	private AddPunchService addPunchService;

	@GetMapping("/addPunch")
	public ResponseEntity<String> addPunch() {

		return addPunchService.punchRequest(LocalDateTime.now().toString(), 1);
	}

	@GetMapping("/addTimeOff/{leaveType}")
	public boolean addTimeOff(@PathVariable String leaveType) {

		return addPunchService.addTimeOff(LocalDate.now().toString(), LocalDate.now().toString(), leaveType);
	}

	@GetMapping("/addPayCode")
	public ResponseEntity<String> addPayCode() {

		return addPunchService.createPayCode();
	}

	@GetMapping("/getShift/{shiftDate}")
	public ResponseEntity<String> getShift(@PathVariable String shiftDate)
			throws JsonMappingException, JsonProcessingException {

		return addPunchService.getShift(shiftDate);
	}

	@GetMapping("/leaveBalance")
	public ResponseEntity<String> absentData(String leaveType) throws JsonMappingException, JsonProcessingException {
		return addPunchService.getLeaveBalance();
	}

}
