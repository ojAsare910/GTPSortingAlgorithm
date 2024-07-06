package com.justiceasare.controller;

import com.justiceasare.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Controller
public class SortingController {

    @Autowired
    private SortingService sortingService;

    @GetMapping("/api/sort")
    public ResponseEntity<?> sortApi(@RequestParam("array") String[] strArray, @RequestParam("algorithm") String algorithm) {
        try {
            int[] array = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
            int[] sortedArray = sortingService.sort(array, algorithm);

            return ResponseEntity.ok(sortedArray);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(new ErrorResponse("Invalid input: Please enter a comma-separated list of integers."), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ErrorResponse("Unsupported algorithm: " + algorithm + ". Please choose a valid sorting algorithm."), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An unexpected error occurred: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/api/sort")
    public ResponseEntity<?> sortApi(@RequestBody SortRequest sortRequest) {
        try {
            String[] strArray = sortRequest.getArray();
            String algorithm = sortRequest.getAlgorithm();

            int[] array = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
            int[] sortedArray = sortingService.sort(array, algorithm);

            return ResponseEntity.ok(sortedArray);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(new ErrorResponse("Invalid input: Please enter a comma-separated list of integers."), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ErrorResponse("Unsupported algorithm: " + sortRequest.getAlgorithm() + ". Please choose a valid sorting algorithm."), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An unexpected error occurred: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sort")
    public ModelAndView sort(@RequestParam("array") String arrayStr, @RequestParam("algorithm") String algorithm) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            String[] strArray = arrayStr.split(",");
            int[] array = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();

            int[] sortedArray = sortingService.sort(array, algorithm);

            String sortedArrayStr = Arrays.stream(sortedArray)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));
            modelAndView.setViewName("result");
            modelAndView.addObject("sortedArray", sortedArrayStr);

        }  catch (NumberFormatException e) {
            modelAndView.setViewName("/");
            modelAndView.addObject("error", "Invalid input: Please enter a comma-separated list of integers.");
        } catch (IllegalArgumentException e) {
            modelAndView.setViewName("/");
            modelAndView.addObject("error", "Unsupported algorithm: " + algorithm + ". Please choose a valid sorting algorithm.");
        } catch (Exception e) {
            modelAndView.setViewName("/");
            modelAndView.addObject("error", "An unexpected error occurred: " + e.getMessage());
        }
        return modelAndView;
    }

    @GetMapping("/hateoas")
    public ResponseEntity<RepresentationModel<?>> hateoasLinks() {
        try {
            Link formLink = linkTo(SortingController.class).withRel("Sort Array with Forms via Browser").withType("GET").withTitle("Sort Array Form");
            Link getLink = linkTo(SortingController.class).slash ( "/api/sort?array=5,3,1,4,2&algorithm=quick").withRel("Sort Array with GET via Browser").withType("GET").withTitle("Sort Array Example");
            Link postLink = linkTo(SortingController.class).slash("/api/sort").withRel("Sort Array with POST via POSTMAN").withType("POST").withTitle("Sort Array via POST");

            RepresentationModel<?> hateoasResponse = new RepresentationModel<>();
            hateoasResponse.add(formLink, getLink, postLink);

            return ResponseEntity.ok(hateoasResponse);
        } catch (Exception e) {
            RepresentationModel<?> errorResponse = new RepresentationModel<>();
            errorResponse.add(Link.of("/hateoas").withRel("self").withType("GET").withTitle("HATEOAS Links"));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


    private static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class SortRequest {
        private String[] array;
        private String algorithm;

        public String[] getArray() {
            return array;
        }
        public void setArray(String[] array) {
            this.array = array;
        }
        public String getAlgorithm() {
            return algorithm;
        }
        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }
    }

}
