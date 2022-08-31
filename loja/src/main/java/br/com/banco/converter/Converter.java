package br.com.banco.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {



        public static ModelMapper modelMapper = new ModelMapper();


        static {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        }


        protected Converter() {
        }

        public static <D, T> D map(final T entity, Class<D> outClass) {

            return modelMapper.map(entity, outClass);
        }


        public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {

            List<D> list = entityList.stream()
                    .map(entity -> map(entity, outCLass))
                    .collect(Collectors.toList());

            return list;


        }

        public static <S, D> D map(final S source, D destination) {
            modelMapper.map(source, destination);
            return destination;
        }




}
