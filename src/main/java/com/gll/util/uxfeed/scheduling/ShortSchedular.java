package com.gll.util.uxfeed.scheduling;

import org.springframework.stereotype.Repository;
import org.springframework.scheduling.annotation.Scheduled;

@Repository
public class ShortSchedular {
	@Scheduled(fixedRate=2500)
	public void printMessage() {
		System.out.println("I am frequent checker!!!");
	}
}
