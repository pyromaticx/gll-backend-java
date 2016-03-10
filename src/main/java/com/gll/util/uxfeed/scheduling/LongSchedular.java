package com.gll.util.uxfeed.scheduling;

import org.springframework.stereotype.Repository;
import org.springframework.scheduling.annotation.Scheduled;

@Repository
public class LongSchedular {

	@Scheduled(fixedRate=5000)
	public void printMessage() {
		System.out.println("I will let down dyno....");
	}
}
