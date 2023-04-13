package com.dialogflow.timecard.punch.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dialogflow.timecard.punch.model.Attribute;
import com.dialogflow.timecard.punch.model.RootLeaves;
import com.dialogflow.timecard.punch.model.RootShift;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AddPunchService {

	private static List<String> fetchCookie() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.add("X-OpenAM-Username", {username});
		requestHeaders.add("X-OpenAM-Password", {password});

		String absoluteUrl = "$auth_url";
		ResponseEntity<String> response;
		response = restTemplate.exchange(absoluteUrl, HttpMethod.POST, new HttpEntity<String>(requestHeaders),
				String.class);
		System.out.println(response.getHeaders());
		HttpHeaders resHeaders = response.getHeaders();
		List<String> setCookie = resHeaders.get(HttpHeaders.SET_COOKIE);
		System.out.println(setCookie);
		return setCookie;
	}

	public ResponseEntity<String> punchRequest(String punchDtm, int punchType) {
		List<String> setCookie = fetchCookie();
		String punchRequestBody = "{\"punches\":[{\"punchDtm\":\"" + punchDtm
				+ "\",\"typeOverride\":{\"typeOverrideId\":\"1\"}}],\"employees\":[{\"qualifier\":\"20335\"}],\"startDate\":\"2023-01-30T00:00:00.000\",\"timeframe_id\":\"CURRENT_PAY_PERIOD\"}";

		String absoluteUrl = "{machine}80/wfc/restcall/timekeeping/v1/punches/multi_create";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		for (int i = 0; i < setCookie.size(); i++) {
			System.out.println("Cookie {0} : {1}" + (i + 1) + setCookie.get(i));
			requestHeaders.add(HttpHeaders.COOKIE, setCookie.get(i).replace("HttpOnly", ""));
		}

		HttpEntity<String> requestEntity = new HttpEntity<String>(punchRequestBody, requestHeaders);
		System.out.println("Body:" + requestEntity.getBody());
		ResponseEntity<String> response = restTemplate.exchange(absoluteUrl, HttpMethod.POST, requestEntity,
				String.class);
		return response;

	}

	public boolean addTimeOff(String startDate, String endDate, String leaveType) {
		List<String> setCookie = fetchCookie();
		System.out.println("incommin leave type" + leaveType);
		String absoluteUrl = "{machine}80/wfc/restcall/v1/scheduling/timeoff";
		String TimeOFFRequestBody = null;
		if (leaveType.equalsIgnoreCase("Sick")) {
			TimeOFFRequestBody = "{\"timeOffRequest\":{\"requestSubType\":{\"name\":\"PTO Hourly\"},\"periods\":[{\"symbolicAmount\":{\"qualifier\":\"FULL_DAY\"},\"startDate\":\""
					+ startDate + "\",\"endDate\":\"" + endDate + "\"}],\"employee\":{\"qualifier\":\"20335\"}}}";
		} else if (leaveType.equalsIgnoreCase("Vacation")) {
			TimeOFFRequestBody = "{\"timeOffRequest\":{\"requestSubType\":{\"name\":\"Vacation\"},\"periods\":[{\"symbolicAmount\":{\"qualifier\":\"FULL_DAY\"},\"startDate\":\""
					+ startDate + "\",\"endDate\":\"" + endDate + "\"}],\"employee\":{\"qualifier\":\"20335\"}}}";
		}
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		for (int i = 0; i < setCookie.size(); i++) {
			System.out.println("Cookie {0} : {1}" + (i + 1) + setCookie.get(i));
			requestHeaders.add(HttpHeaders.COOKIE, setCookie.get(i).replace("HttpOnly", ""));
		}

		HttpEntity<String> requestEntity = new HttpEntity<String>(TimeOFFRequestBody, requestHeaders);
		System.out.println("Body:" + requestEntity.getBody());
		ResponseEntity<String> response = restTemplate.exchange(absoluteUrl, HttpMethod.POST, requestEntity,
				String.class);

		return response != null ? true : false;

	}

	public ResponseEntity<String> createPayCode() {
		List<String> setCookie = fetchCookie();
		String punchRequestBody = "{\n" + "    \"name\": \"48 Hours\",\n" + "    \"shortName\": \"48\",\n"
				+ "    \"type\": \"Regular\",\n" + "    \"unit\": \"HOUR\",\n" + "    \"combined\": false,\n"
				+ "    \"money\": false,\n" + "    \"totals\": false,\n" + "    \"excusedAbsence\": false,\n"
				+ "    \"wageMultiplier\": 0.0,\n" + "    \"wageAddition\": 0.0,\n"
				+ "    \"addToTimecardTotal\": false,\n" + "    \"visibleToTimecardSchedule\": false,\n"
				+ "    \"visibleToUser\": true,\n" + "    \"visibleToReports\": false,\n"
				+ "    \"checkAvailability\": 0,\n" + "    \"scheduledHoursType\": \"Administrative\"\n" + "}";

		String absoluteUrl = "{machine}80/wfc/restcall/v1/timekeeping/setup/pay_codes/";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		for (int i = 0; i < setCookie.size(); i++) {
			System.out.println("Cookie {0} : {1}" + (i + 1) + setCookie.get(i));
			requestHeaders.add(HttpHeaders.COOKIE, setCookie.get(i).replace("HttpOnly", ""));
		}

		HttpEntity<String> requestEntity = new HttpEntity<String>(punchRequestBody, requestHeaders);
		System.out.println("Body:" + requestEntity.getBody());
		ResponseEntity<String> response = restTemplate.exchange(absoluteUrl, HttpMethod.POST, requestEntity,
				String.class);
		return response;

	}

	public ResponseEntity<String> getShift(String shiftDate) throws JsonMappingException, JsonProcessingException {
		List<String> setCookie = fetchCookie();
		System.out.println("incomming shiftDate" + shiftDate);
		String absoluteUrl = "{machine}80/wfc/restcall/v1/scheduling/schedule/multi_read";
		String shiftRequestBody = null;
		System.out.println(LocalDate.now());
		if (shiftDate.equalsIgnoreCase("today")) {
			shiftRequestBody = "{   \"select\": [     \"shifts\"   ],   \"where\": {\"employees\": {\"employees\": {  \"qualifiers\": [20335  ]},\"dateRange\": {  \"startDate\": \""
					+ LocalDate.now().toString() + "\",\"endDate\":\"" + LocalDate.now().toString() + "\"}}   } }";
		} /*
			 * else if (shiftDate.equalsIgnoreCase("tomorrow")) { shiftRequestBody =
			 * "{   \"select\": [     \"shifts\"   ],   \"where\": {\"employees\": {\"employees\": {  \"qualifiers\": [20335  ]},\"dateRange\": {  \"startDate\":\""
			 * + LocalDate.now().plusDays(1).toString() + "\",\"endDate\":\"" +
			 * LocalDate.now().plusDays(1).toString() + "\"}}   } }"; }
			 */
		System.out.println("shiftRequestBody" + shiftRequestBody);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		for (int i = 0; i < setCookie.size(); i++) {
			System.out.println("Cookie {0} : {1}" + (i + 1) + setCookie.get(i));
			requestHeaders.add(HttpHeaders.COOKIE, setCookie.get(i).replace("HttpOnly", ""));
		}

		HttpEntity<String> requestEntity = new HttpEntity<String>(shiftRequestBody, requestHeaders);
		System.out.println("Body:" + requestEntity.getBody());
		ResponseEntity<String> response = restTemplate.exchange(absoluteUrl, HttpMethod.POST, requestEntity,
				String.class);
		String responseBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// Map<String, Object> responseMap = mapper.readValue(responseBody,
		// HashMap.class);
		RootShift rootShift = mapper.readValue(responseBody, RootShift.class);
		// System.out.println(System.out.println(rootShift.getShifts().get(0)));
		// Map<String, String> responseMap = new HashMap<>();
		/*
		 * for (int i = 0; i < rootShift.getShifts().size(); i++) {
		 * responseMap.put(rootShift.getEmployees().get(i).getId().toString(),
		 * rootShift.getShifts().get(i).getSegments().get(0).getOrgJobRef().getQualifier
		 * ().toString());
		 * 
		 * }
		 */

		List<String> shiftList = new ArrayList<String>();
		shiftList.add("Location : "
				+ rootShift.getShifts().get(0).getSegments().get(0).getOrgJobRef().getQualifier().toString());
		shiftList.add("startTime : " + rootShift.getShifts().get(0).getSegments().get(0).getStartDateTime().toString());
		shiftList.add("endTime: " + rootShift.getShifts().get(0).getSegments().get(0).getEndDateTime().toString());

		// System.out.println(responseMap);
		// System.out.println(rootShift.getShifts().get(0).getSegments().get(0).getOrgJobRef().getQualifier().toString());
		// System.out.println(rootShift.getShifts().get(0).getSegments().get(0).getStartDateTime().toString());
		// System.out.println(rootShift.getShifts().get(0).getSegments().get(0).getEndDateTime().toString());

		String jsonResponse = mapper.writeValueAsString(shiftList);
		ResponseEntity<String> finalResponse = new ResponseEntity(jsonResponse, HttpStatus.OK);
		return finalResponse;

	}

	public ResponseEntity<String> getLeaveBalance() throws JsonMappingException, JsonProcessingException {
		List<String> setCookie = fetchCookie();
		String punchRequestBody = "{\"employees\":[\"243\"],\"columns\":[{\"name\":\"TK_AS_DLY_SMRY_AVBL_BLNC_HOURS\"},{\"name\":\"TK_AS_DLY_SMRY_AVBL_BLNC_DAYS\"},{\"name\":\"TK_AS_DLY_SMRY_AVBL_BLNC_MONEY_AMT\"},{\"name\":\"TK_AS_DLY_SMRY_CURR_BLNC_VSTD_HOURS_AMT\"},{\"name\":\"TK_AS_DLY_SMRY_CURR_BLNC_VSTD_DAYS_AMT\"},{\"name\":\"TK_AS_DLY_SMRY_CURR_BLNC_VSTD_MONEY_AMT\"},{\"name\":\"TK_AS_DLY_SMRY_CURR_BLNC_PROB_HOURS_AMT\"},{\"name\":\"TK_AS_DLY_SMRY_CURR_BLNC_PROB_DAYS_AMT\"},{\"name\":\"TK_AS_DLY_SMRY_CURR_BLNC_PROB_MONEY_AMT\"},{\"name\":\"TK_ACC_SMRY_ACCODE_ID\"},{\"name\":\"TK_ACC_SMRY_ACCODE_NAME\"},{\"name\":\"TK_ACC_SMRY_ACCODE_TYPE_NAME\"}],\"dateRange\":{\"startDate\":\"2023-01-01\",\"endDate\":\"2023-01-30\"},\"additionalData\":{\"requiredCT\":false}}";

		String absoluteUrl = "{machine}80/wfc/restcall/v1/timekeeping/internal/ia/accrual/multi_read";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		for (int i = 0; i < setCookie.size(); i++) {
			System.out.println("Cookie {0} : {1}" + (i + 1) + setCookie.get(i));
			requestHeaders.add(HttpHeaders.COOKIE, setCookie.get(i).replace("HttpOnly", ""));
		}

		HttpEntity<String> requestEntity = new HttpEntity<String>(punchRequestBody, requestHeaders);
		System.out.println("Body:" + requestEntity.getBody());
		ResponseEntity<String> response = restTemplate.exchange(absoluteUrl, HttpMethod.POST, requestEntity,
				String.class);
		String responseBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		// Map<String, Object> responseMap = mapper.readValue(responseBody,
		// HashMap.class);
		RootLeaves root = mapper.readValue(responseBody, RootLeaves.class);
		List<Attribute> attributeList = new ArrayList<>();
		attributeList = root.getData().get(0).getAttributes();
		Map<String, String> responseMap = new HashMap<>();
		for (int i = 0; i < root.getData().size(); i++) {
			responseMap.put(root.getData().get(i).getAttributes().get(10).getValue(),
					root.getData().get(i).getAttributes().get(9).getValue());

		}
		System.out.println(responseMap);
		
		String jsonResponse = mapper.writeValueAsString(responseMap);
		ResponseEntity<String> finalResponse = new ResponseEntity(jsonResponse, HttpStatus.OK);
		return finalResponse;

	}

}
