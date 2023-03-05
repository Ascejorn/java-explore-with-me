package ru.practicum.ewm.category.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.category.dto.CategoryDto;
import ru.practicum.ewm.category.service.CategoryService;
import ru.practicum.ewm.util.ControllerLog;
import ru.practicum.stats.client.StatsClient;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/categories")
@Slf4j
public class PublicCategoryController {

    private final CategoryService categoryService;

    private final StatsClient statsClient;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<CategoryDto> findCategories(
            HttpServletRequest request,
            @RequestParam(required = false, defaultValue = "0") Integer from,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        statsClient.hit(request);
        log.info("{}", ControllerLog.createUrlInfo(request));
        return categoryService.findCategories(from, size);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto findCategory(@PathVariable Long id, HttpServletRequest request) {
        log.info("{}", ControllerLog.createUrlInfo(request));
        return categoryService.findCategory(id);
    }
}