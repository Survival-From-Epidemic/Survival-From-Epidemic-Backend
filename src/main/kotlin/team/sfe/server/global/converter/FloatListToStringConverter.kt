package team.sfe.server.global.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class FloatListToStringConverter : AttributeConverter<List<Float>, String>{
    override fun convertToDatabaseColumn(attribute: List<Float>?): String {
        val sb = StringBuilder()
        attribute!!.map {
            sb.append("$it|")
        }
        return sb.toString()
    }

    override fun convertToEntityAttribute(dbData: String?): List<Float> {
        val list = mutableListOf<Float>()
        dbData!!.split("|").map { list += it.toFloat() }
        return list
    }
}
