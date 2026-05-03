package com.example.task1.email.service.impl;

import com.example.task1.email.dto.EmailDto;
import com.example.task1.email.mapper.EmailMapper;
import com.example.task1.email.model.Email;
import com.example.task1.email.repo.EmailRepo;
import com.example.task1.email.service.EmailService;
import com.example.task1.employee.model.Employee;
import com.example.task1.employee.repo.EmployeeRepo;
import com.example.task1.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class EmailServiceImpl implements EmailService {
    EmailRepo emailRepo;
    EmailMapper emailMapper;
    EmployeeRepo employeeRepo;

    public EmailServiceImpl(EmailRepo emailRepo, EmailMapper emailMapper, EmployeeRepo employeeRepo){
        this.emailRepo = emailRepo;
        this.emailMapper = emailMapper;
        this.employeeRepo = employeeRepo;
    }


    @Override
    public EmailDto createEmail(EmailDto emailDto) {
        Email email = emailMapper.toEntity(emailDto);

        Employee employee = employeeRepo.findById(emailDto.getEmployee().getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        email.setEmployee(employee);
        email = emailRepo.save(email);
        return emailMapper.toDto(email);
    }

    @Override
    public EmailDto updateEmail(EmailDto emailDto) {
        Email email = emailMapper.toEntity(emailDto);
        email = emailRepo.save(email);
        return emailDto;
    }

    @Override
    public void deleteEmail(Long id) {
        emailRepo.deleteById(id);
    }

    @Override
    public List<EmailDto> getEmails() {
        List<Email> emails = emailRepo.findAll();
        return emailMapper.toDtoList(emails);
    }

    @Override
    public List<EmailDto> getEmailByName(String name) {
        List<Email> emails = emailRepo.findByName(name);
        return emailMapper.toDtoList(emails);
    }

    @Override
    public List<EmailDto> getEmailsByNames(List<String> names) {
        List<Email> emails = emailRepo.findByNameIn(names);
        return emailMapper.toDtoList(emails);
    }

    @Override
    public EmailDto getEmailByContent(String content) {
        System.out.println("Content from request: " + content);
        Email email = emailRepo.findByContent(content);
        return emailMapper.toDto(email);
    }
}
