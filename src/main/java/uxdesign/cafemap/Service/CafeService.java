package uxdesign.cafemap.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dao.CafeDao;
import uxdesign.cafemap.Dto.CafeListResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeDao cafeDao;
    public BaseResponse<CafeListResponse> getCafes(){
        CafeListResponse response = new CafeListResponse();
        response.setCafeList(cafeDao.getCafes());
        return new BaseResponse<>(response);
    }
}
