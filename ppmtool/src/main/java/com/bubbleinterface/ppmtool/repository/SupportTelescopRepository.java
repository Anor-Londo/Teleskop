package com.bubbleinterface.ppmtool.repository;

import com.bubbleinterface.ppmtool.domain.SupportTelescop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTelescopRepository extends CrudRepository<SupportTelescop, Long> {
}
