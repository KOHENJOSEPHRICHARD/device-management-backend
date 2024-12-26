package com.phone.smart.Repository;


import com.phone.smart.Model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository<Log> extends JpaRepository<Log, Long> {
}
