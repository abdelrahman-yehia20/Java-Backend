package com.example.task1.email.service;

import com.example.task1.email.dto.EmailDto;
import com.example.task1.employee.model.Employee;

import java.util.List;

public interface EmailService {

    EmailDto createEmail(EmailDto emailDto);

    EmailDto updateEmail(EmailDto emailDto);

    void deleteEmail(Long id);

    List<EmailDto> getEmails();

    List<EmailDto> getEmailByName(String name);

    List<EmailDto> getEmailsByNames(List<String> names);

    EmailDto getEmailByContent(String content);

}
