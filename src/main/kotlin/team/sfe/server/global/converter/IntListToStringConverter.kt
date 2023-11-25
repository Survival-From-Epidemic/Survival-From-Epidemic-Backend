package team.sfe.server.global.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class IntListToStringConverter : AttributeConverter<List<Int>, String> {
    override fun convertToDatabaseColumn(attribute: List<Int>?) = attribute!!.joinToString("|")

    override fun convertToEntityAttribute(dbData: String?) = dbData!!.split("|").map { it.toInt() }
}
