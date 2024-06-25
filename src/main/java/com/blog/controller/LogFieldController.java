package com.blog.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.common.Result;
import com.blog.entity.LogField;
import com.blog.service.LogFieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/field")
@Slf4j
public class LogFieldController {

    @Autowired
    private LogFieldService logFieldService;

    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String name) {
        log.info("page={},pageSize={},name={}", page, pageSize, name);
        //构造分页构造器
        Page<LogField> pageInfo = new Page<>(page, pageSize);
        //构造条件构造器
        LambdaQueryWrapper<LogField> wrapper = new LambdaQueryWrapper<>();
        //添加过滤条件（当我们没有输入name时，就相当于查询所有了）
        wrapper.like(!(name == null || "".equals(name)), LogField::getName, name);
        //并对查询的结果进行降序排序，根据更新时间
        wrapper.orderByDesc(LogField::getUpdateTime);
        //执行查询
        logFieldService.page(pageInfo, wrapper);
        return Result.success(pageInfo);
    }
}
