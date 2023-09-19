package com.pet.sumpro.services;

import com.pet.sumpro.converter.FormDataDtoConverter;
import com.pet.sumpro.domain.AppResponseBuilder;
import com.pet.sumpro.domain.DataModel;
import com.pet.sumpro.dtos.AppResponseDto;
import com.pet.sumpro.dtos.FormDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MoneyWritingService {

    private final FormDataDtoConverter formDataDtoConverter;

    private final AppResponseBuilder builder;
    public AppResponseDto getMoneyWriting(FormDataDto dto) {
        DataModel dataModel = formDataDtoConverter.formDataDtoToDataModel(dto);

        return builder.create()
                .addResponses(dataModel)
                .getAppResponses();

    }

}
