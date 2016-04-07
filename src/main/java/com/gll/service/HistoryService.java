package com.gll.service;

import java.util.List;

import com.gll.model.HistoryModel;

public interface HistoryService {
	public void save(HistoryModel historyModel);
	public List<HistoryModel> displayAll();
	public HistoryModel display(int historyId);
	public void update(HistoryModel historyModel);
	public void patch(HistoryModel historyModel);
	public void delete(int historyId);
}
