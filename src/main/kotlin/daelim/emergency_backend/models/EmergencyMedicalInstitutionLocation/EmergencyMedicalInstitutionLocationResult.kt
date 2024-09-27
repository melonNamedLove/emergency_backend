
package daelim.emergency_backend.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import daelim.emergency_backend.models.AvailavleBedInfo.Header


//응급의료기관 위치정보 조회


@JsonRootName("response")
data class EmergencyMedicalInstitutionLocationResult(
    @set:JsonProperty("header")
    var header:Header?,

    @set:JsonProperty("body")
    var body:EmergencyMedicalInstitutionLocationBody?,
)

@JsonRootName("body")
data class EmergencyMedicalInstitutionLocationBody(
    @set:JsonProperty("items")
    var items:EmergencyMedicalInstitutionLocationItems?,

    @set:JsonProperty("numOfRows")//한 페이지 결과수
    var numOfRows:Int?,

    @set:JsonProperty("pageNo")//페이지번호
    var pageNo:Int?,

    @set:JsonProperty("totalCount")//총 결과수
    var totalCount:Int?,
)

@JsonRootName("items")
data class EmergencyMedicalInstitutionLocationItems(
    @set:JsonProperty("item")
    var item:List<EmergencyMedicalInstitutionLocation>?,
)

@JsonRootName("item")
data class EmergencyMedicalInstitutionLocation(
    @set:JsonProperty("rnum")
    var rnum: Int? = null, // 일련번호

    @set:JsonProperty("cnt")
    var cnt: Int? = null, // 건수

    @set:JsonProperty("distance")
    var distance: Double? = null, // 거리

    @set:JsonProperty("dutyAddr")
    var dutyAddr: String? = null, // 주소

    @set:JsonProperty("dutyDiv")
    var dutyDiv: String? = null, // 병원 분류

    @set:JsonProperty("dutyDivName")
    var dutyDivName: String? = null, // 병원 분류명

    @set:JsonProperty("dutyFax")
    var dutyFax: String? = null, // 팩스번호

    @set:JsonProperty("dutyName")
    var dutyName: String? = null, // 기관명

    @set:JsonProperty("dutyTel1")
    var dutyTel1: String? = null, // 대표전화1

    @set:JsonProperty("endTime")
    var endTime: String? = null, // 종료시간

    @set:JsonProperty("hpid")
    var hpid: String? = null, // 기관ID

    @set:JsonProperty("latitude")
    var latitude: Double? = null, // 병원위도

    @set:JsonProperty("longitude")
    var longitude: Double? = null, // 병원경도

    @set:JsonProperty("startTime")
    var startTime: String? = null // 시작시간
)