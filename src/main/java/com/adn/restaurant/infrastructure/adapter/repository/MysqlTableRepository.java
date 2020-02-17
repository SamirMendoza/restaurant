package com.adn.restaurant.infrastructure.adapter.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.adn.restaurant.domain.ports.TableRepository;

@Repository
@Transactional
public class MysqlTableRepository implements TableRepository {

}
