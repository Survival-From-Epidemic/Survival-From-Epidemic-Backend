package team.sfe.server.global.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class StringListToStringConverter : AttributeConverter<List<String>, String> {
    override fun convertToDatabaseColumn(attribute: List<String>?) = attribute!!.joinToString("|")

    override fun convertToEntityAttribute(dbData: String?) = dbData!!.split("|")
}
