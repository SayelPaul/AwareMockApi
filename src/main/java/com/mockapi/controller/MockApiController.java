package com.mockapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mockapi.config.DeviceType;
import com.mockapi.config.EventTrigger;
import com.mockapi.config.EventType;
import com.mockapi.config.LocationTechType;
import com.mockapi.config.RadioTechType;
import com.mockapi.dto.AlertDetails;
import com.mockapi.dto.Alerts;
import com.mockapi.dto.BatteryStatus;
import com.mockapi.dto.DeviceTelemetryData;
import com.mockapi.dto.DeviceTelemetryMessage;
import com.mockapi.dto.HumidityData;
import com.mockapi.dto.LocationData;
import com.mockapi.dto.PressureData;
import com.mockapi.dto.TemperatureData;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class MockApiController {

	@PostMapping("alerts")
	@Operation(summary = "API for triggering mock alerts", tags = "MockApi")
	public Alerts alert(@RequestHeader String url, @RequestHeader String api_key, @RequestBody Alerts payload) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-API-Key", api_key);

		
		if(payload.getMessageType()!=null && payload.getSerialNumber()!=null && payload.getServerReceivedTimeStamp()!=null &&
				payload.getDeviceReportingTimeStamp()!=null && payload.getShipmentID()!=null && payload.getDeviceType()!=null
				&& payload.getLocation()!=null && payload.getAlertDetails()!=null) 
		{
			
			HttpEntity<String> entity = new HttpEntity<>(payload.toString(), headers);
	        restTemplate.exchange(url, HttpMethod.POST, entity, Alerts.class);
			
			return payload;
			
		}
			
			Alerts al=new Alerts();
			al.setMessageType("alert");
			al.setSerialNumber("TK3400001");
			al.setServerReceivedTimeStamp(12345678);
			al.setDeviceReportingTimeStamp(12345678);
			al.setShipmentID(787846);
			al.setDeviceType(DeviceType.TRACKER);
			
			LocationData ld=new LocationData();
			ld.setLatitude(37.35);
			ld.setLongitude(-122.05);
			ld.setTimeStamp(3544566);
			ld.setLocationTechType(LocationTechType.GNSS);
			ld.setRadioTechType(RadioTechType.G2);
			ld.setOperatorName("Telefonica Spain");
			ld.setHorizontalUncertainity(24);
			ld.setAltitude(500.00);
			ld.setAltitudeUncertainity(39);
			al.setLocation(ld);
			
			AlertDetails ad=new AlertDetails();
			ad.setEventType(EventType.Breach);
			ad.setEventTrigger(EventTrigger.Temperature);
			ad.setVal(92.334);
			ad.setThreshold(95.334654);
			ad.setTimeStamp(3544566);
			ad.setMessage("Temperature/Pressure/Humidity is X, It is approaching threshold Y");
			ad.setDuration(3456);
			al.setAlertDetails(ad);
					
			
			HttpEntity<String> entity = new HttpEntity<>(al.toString(), headers);
	        restTemplate.exchange(url, HttpMethod.POST, entity, Alerts.class);
			
			return al;
			

	}
	
	
	@PostMapping("telemetry")
	@Operation(summary = "API for triggering mock telemetry", tags = "MockApi")
	public DeviceTelemetryMessage telemetry(@RequestHeader String url, @RequestHeader String api_key,
			@RequestBody DeviceTelemetryMessage payload) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-API-Key", api_key);

		
		if(payload.getMessageType()!=null && payload.getDeviceTelemetryReport()!=null) {
			
			HttpEntity<String> entity = new HttpEntity<>(payload.toString(), headers);
	        restTemplate.exchange(url, HttpMethod.POST, entity, DeviceTelemetryMessage.class);
			
				return payload;
			
		}
		
		DeviceTelemetryMessage dtm = new DeviceTelemetryMessage();
		dtm.setMessageType("deviceTelemetryReport");
		
		List<DeviceTelemetryData> dtdlist= new ArrayList<>();
		DeviceTelemetryData dtd = new DeviceTelemetryData();
		dtd.setSerialNumber("TK3400001");
		dtd.setServerReceivedTimeStamp(12345678);
		dtd.setDeviceReportingTimeStamp(12345678);
		dtd.setDeviceType(DeviceType.TRACKER);
		dtd.setSequenceNumber(12);
		List<TemperatureData> templist=new ArrayList<>();
		List<PressureData> presrlist=new ArrayList<>();
		List<HumidityData> humidlist=new ArrayList<>();
		
		
		LocationData ld=new LocationData();
		ld.setLatitude(37.35);
		ld.setLongitude(-122.05);
		ld.setTimeStamp(3544566);
		ld.setLocationTechType(LocationTechType.GNSS);
		ld.setRadioTechType(RadioTechType.G2);
		ld.setOperatorName("Telefonica Spain");
		ld.setHorizontalUncertainity(24);
		ld.setAltitude(500.00);
		ld.setAltitudeUncertainity(39);
		dtd.setLocation(ld);
		
		TemperatureData td=new TemperatureData();
		td.setVal(76.5);
		td.setTimeStamp(3544566);
		templist.add(td);
		dtd.setTemperature(templist);
		
		PressureData pd=new PressureData();
		pd.setVal(1012.51);
		pd.setTimeStamp(3544566);
		presrlist.add(pd);
		dtd.setPressure(presrlist);
		
		HumidityData hd=new HumidityData();
		hd.setVal(39.15);
		hd.setTimeStamp(3544566);
		humidlist.add(hd);
		dtd.setHumidity(humidlist);
		
		BatteryStatus bs=new BatteryStatus();
		bs.setBatteryPercentage(50);
		bs.setRemainingBatteryLife(567654);
		dtd.setBatteryStatus(bs);
		
		dtdlist.add(dtd);
		dtm.setDeviceTelemetryReport(dtdlist);
		
		HttpEntity<String> entity = new HttpEntity<>(dtm.toString(), headers);
        restTemplate.exchange(url, HttpMethod.POST, entity, DeviceTelemetryMessage.class);

		return dtm;
	}
}