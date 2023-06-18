// package io.swagger.utils;

// import com.fasterxml.jackson.databind.JavaType;
// import com.fasterxml.jackson.databind.type.TypeFactory;
// import com.fasterxml.jackson.databind.util.Converter;

// import io.swagger.resources.FamilyMemberResource.GenderEnum;

// public class StringToEnumConverter implements Converter<String, GenderEnum> {
//     @Override
//     public GenderEnum convert(String source) {
//         return GenderEnum.valueOf(source.toUpperCase());
//     }

//     @Override
//     public JavaType getInputType(TypeFactory typeFactory) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public JavaType getOutputType(TypeFactory typeFactory) {
//         // TODO Auto-generated method stub
//         return null;
//     }
// }

