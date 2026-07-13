package de.htwberlin.wi.codefirst.article;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@Tag(name = "Article", description = "Verwaltung von Artikeln")
public interface ArticleApi {
        final String PATH_GET_ALL_ARTICLES = "/api/v1/articles";

        @Operation(operationId = "getAllArticles", summary = "Eine Liste aller Artikel abrufen.", tags = {
                        "Article" }, responses = {
                                        @ApiResponse(responseCode = "200", description = "Artikelliste erfolgreich geladen.", content = {
                                                        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ArticleWdto.class)), examples = @ExampleObject(value = "[{\"id\": 23, \"name\": \"Weintrauben dunkel\", \"category\": \"OBST\", \"price\": 1.49, \"createdAt\": \"2026-07-02T14:00:00Z\"}]"))
                                        }),
                                        @ApiResponse(responseCode = "default", description = "Ein interner Serverfehler ist aufgetreten.", content = @Content(schema = @Schema(hidden = true)))
                        })
        @RequestMapping(method = RequestMethod.GET, value = ArticleApi.PATH_GET_ALL_ARTICLES, produces = {
                        "application/json" })
        public ResponseEntity<List<ArticleWdto>> getAllArticles();

        String PATH_GET_ARTICLE_BY_ID = "/api/v1/articles/{articleId}";

        @Operation(operationId = "getArticleById", summary = "Die Details eines spezifischen Artikels abrufen.", tags = {
                        "Article" }, responses = {
                                        @ApiResponse(responseCode = "200", description = "Artikel erfolgreich geladen.", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleWdto.class), examples = @ExampleObject(value = "{\"id\": 23, \"name\": \"Weintrauben dunkel\", \"category\": \"OBST\", \"price\": 1.49, \"createdAt\": \"2026-07-02T14:00:00Z\"}"))
                                        }),
                                        @ApiResponse(responseCode = "404", description = "Die angeforderte Ressource wurde nicht gefunden.", content = @Content(schema = @Schema(hidden = true))),
                                        @ApiResponse(responseCode = "default", description = "Ein interner Serverfehler ist aufgetreten.", content = @Content(schema = @Schema(hidden = true)))
                        })
        @RequestMapping(method = RequestMethod.GET, value = PATH_GET_ARTICLE_BY_ID, produces = {
                        "application/json" })
        public ResponseEntity<ArticleWdto> getArticleById(
                        @Parameter(name = "articleId", description = "Der eindeutige Identifikationsparameter eines Artikels.", required = true, in = ParameterIn.PATH, example = "1") @PathVariable("articleId") Long articleId);
}
