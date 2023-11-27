package uxdesign.cafemap.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uxdesign.cafemap.Common.Response.BaseResponse;
import uxdesign.cafemap.Dao.CafeDao;
import uxdesign.cafemap.Dto.Request.CafeIdRequest;
import uxdesign.cafemap.Dto.Request.LocationRequest;
import uxdesign.cafemap.Dto.Request.SearchRequest;
import uxdesign.cafemap.Dto.Response.CafeDetailResponse;
import uxdesign.cafemap.Dto.Response.CafeListResponse;
import uxdesign.cafemap.Dto.Response.MarkerCafeResponse;

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
    public BaseResponse<CafeDetailResponse> getCafeDetail(CafeIdRequest cafeIdRequest){
        CafeDetailResponse cafeDetailResponse = cafeDao.getCafeDetail(cafeIdRequest.getCafeId());
        return new BaseResponse<>(cafeDetailResponse);
    }
    public BaseResponse<MarkerCafeResponse> getCafeMarker(LocationRequest locationRequest){
        MarkerCafeResponse markerCafeResponse = cafeDao.getCafeMarker(locationRequest.getLongitude(), locationRequest.getLatitude());
        return new BaseResponse<>(markerCafeResponse);
    }
    public BaseResponse<CafeListResponse> searchCafe(SearchRequest searchRequest){
        CafeListResponse response = new CafeListResponse();
        response.setCafeList(cafeDao.getCafesByName(searchRequest.getSearch()));
        return new BaseResponse<>(response);
    }
}
