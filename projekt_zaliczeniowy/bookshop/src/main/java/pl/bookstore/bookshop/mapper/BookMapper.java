package pl.bookstore.bookshop.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import pl.bookstore.bookshop.model.Book;
import pl.bookstore.model.BookDetails;
import pl.bookstore.model.BookRequest;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

    @Mapping(target = "bookId", ignore = true)
    @Mapping(target = "visitorCount", ignore = true)
    @Mapping(target = "author", ignore = true)
    Book toEntity(BookRequest bookRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorId", ignore = true)
    BookDetails toDetails(Book book);
}
