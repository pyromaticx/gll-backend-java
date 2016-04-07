package com.gll.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gll.domain.AnnotationModel;

public interface AnnotationService  extends PagingAndSortingRepository<AnnotationModel, Long>  {

}
