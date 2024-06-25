package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.entity.LogField;
import com.blog.mapper.LogFieldMapper;
import com.blog.service.LogFieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogFieldServiceImpl extends ServiceImpl<LogFieldMapper, LogField> implements LogFieldService {

}
