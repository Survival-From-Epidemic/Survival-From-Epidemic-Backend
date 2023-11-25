package team.sfe.server.global.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class IntListToStringConverter : AttributeConverter<List<Int>, String> {
    override fun convertToDatabaseColumn(attribute: List<Int>?): String {
        val sb = StringBuilder()
        attribute!!.map {
            sb.append("$it|")
        }
        return sb.toString()
    }

    override fun convertToEntityAttribute(dbData: String?): List<Int> {
        val list = mutableListOf<Int>()
        dbData!!.split("|").map { list += it.toInt() }
        return list
    }
}
