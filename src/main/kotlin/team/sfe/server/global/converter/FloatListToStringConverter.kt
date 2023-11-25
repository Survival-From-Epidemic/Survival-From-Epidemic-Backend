package team.sfe.server.global.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class FloatListToStringConverter : AttributeConverter<List<Float>, String> {
    override fun convertToDatabaseColumn(attribute: List<Float>?): String {
        return attribute!!.joinToString("|")
    }

    override fun convertToEntityAttribute(dbData: String?): List<Float> {
        return dbData!!.split("|").map { it.toFloat() }
    }
}
