package com.gll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.HistoryDao;
import com.gll.model.HistoryModel;

@Service("historyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryDao historyDao;

	@Override
	public void save(HistoryModel historyModel) {
		historyDao.save(historyModel);
	}

	@Override
	public List<HistoryModel> displayAll() {
		return historyDao.displayAll();
	}

	@Override
	public HistoryModel display(int historyId) {
		return historyDao.display(historyId);
	}

	@Override
	public void update(HistoryModel historyModel) {
		historyDao.update(historyModel);
	}

	@Override
	public void patch(HistoryModel historyModel) {
	}

	@Override
	public void delete(int historyId) {
		historyDao.delete(historyId);
	}

}
