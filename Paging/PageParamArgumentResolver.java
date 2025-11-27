package com.example.demo.Paging;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PageParamArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String DEFAULT_PAGE_PARAM = "page";
    private static final String DEFAULT_SIZE_PARAM = "size";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // PageParam DTO를 받을 수 있도록 수정
        return parameter.hasParameterAnnotation(PageParam.class) &&
                PageParamDto.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  @NonNull NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

        // page 값 가져오기
        String pageRaw = request.getParameter(DEFAULT_PAGE_PARAM);
        int page = parseOrDefault(pageRaw, 1);

        // size 값 가져오기
        String sizeRaw = request.getParameter(DEFAULT_SIZE_PARAM);
        int size = parseOrDefault(sizeRaw, 10);

        return new PageParamDto(page, size);
    }

    private int parseOrDefault(String value, int defaultValue) {
        if (value == null || value.isBlank()) return defaultValue;
        try {
            int parsed = Integer.parseInt(value);
            if (parsed < 1) throw new PageException("parameter must be >= 1");
            return parsed;
        } catch (NumberFormatException e) {
            throw new PageException("parameter is not a valid integer");
        }
    }
}