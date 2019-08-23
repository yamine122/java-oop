package com.bitcamp.services;

import com.bitcamp.domains.ScheduleBean;

public class ScheduleService {
	private ScheduleBean[] schs;
	private int count;

	
	public ScheduleService() {
		schs = new ScheduleBean[10];
		count = 0;
	}
}
