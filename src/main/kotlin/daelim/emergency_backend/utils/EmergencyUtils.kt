package daelim.emergency_backend.utils

import daelim.emergency_backend.exception.InvalidCoordinatesParameterException
import kotlin.math.*

class EmergencyUtils {
    companion object {
        //m단위 변한
        fun getDistanceWithLonLat(originLat:Double, originLon:Double, targetLat:Double, targetLon:Double):Double{

            if (//
                originLat > 90.0 || originLat < -90.0 //
                || targetLat > 90.0 || targetLat < -90.0 //
                || originLon > 180.0 || originLon < -180.0 //
                || targetLon > 180.0 || targetLon < -180.0 //
            ) {
                throw InvalidCoordinatesParameterException()
            }

            var distance = 0.0
            val R = 6371.0 //지구 평균 반지름 (km)
            
            val dLat = Math.toRadians(targetLat - originLat)
            val dLon = Math.toRadians(targetLon - originLon)

            val a = sin(dLat/2).pow(2) + cos(Math.toRadians(originLat)) * cos(Math.toRadians(targetLat)) * sin(dLon/2).pow(2)
            val c = 2 * atan2(sqrt(a), sqrt(1-a))
            
            //1000을 곱해서 m단위로 변경
            distance = R * c * 1000

            return distance
        }
    }
}

