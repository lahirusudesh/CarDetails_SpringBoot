package com.io.developer.testapp2;

import com.io.developer.testapp2.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CarRepository extends CrudRepository<Car, Long> {
}
