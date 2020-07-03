package com.growbeans.cunity.Alarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.growbeans.cunity.Alarm.service.AlarmService;

@Controller
public class AlarmController {

	@Autowired
	public AlarmService alarmService;

}
