# GTPSortingAlgorithm
The Sorting Algorithm project provides an API for sorting arrays using various sorting algorithms. The service is designed to be extendable, allowing the addition of new sorting algorithms as needed.

## Prerequisites
- **Java Development Kit (JDK) 21**: Ensure you have JDK 21 installed.
- **Apache Tomcat 9**: The project requires Apache Tomcat 9 as the servlet container.
- **Maven**: The project uses Maven for dependency management and build automation.

## Requirements

### Functional Requirements
1. **SortingController**: The controller for handling sorting requests.
    - `hateaosLinks()`: Provides HATEOAS links for the API.
    - `sortApi(String[], String)`: Sorts an array of strings using a specified algorithm.
    - `sortApi(SortRequest)`: Sorts an array based on a detailed request.
    - `sort(String[], String)`: Returns a view after sorting the array of strings using the specified algorithm.

2. **SortingService**: The service interface for sorting.
    - `sort(int[], String)`: Sorts an array of integers using the specified algorithm.

3. **SortingServiceImpl**: The implementation of the `SortingService`.
    - `algorithms`: A map of algorithm names to `SortingAlgorithm` instances.
    - `sort(int[], String)`: Delegates sorting to the appropriate algorithm.

4. **SortingAlgorithm**: An interface for sorting algorithms.
    - `sort(int[])`: Sorts an array of integers.

5. **Sorting Algorithms**: Implementations of `SortingAlgorithm`.
    - **BucketSort**: Implements bucket sort.
    - **QuickSort**: Implements quick sort.
    - **MergeSort**: Implements merge sort.
    - **HeapSort**: Implements heap sort.
    - **RadixSort**: Implements radix sort.

### Non-Functional Requirements
1. **Scalability**: The system should be able to handle large arrays and multiple concurrent requests efficiently.
2. **Extensibility**: New sorting algorithms should be easily added without modifying the existing codebase.
3. **Maintainability**: The code should be modular and follow best practices for readability and maintainability.
4. **Performance**: The sorting operations should be optimized for performance.

### API Endpoints
- `GET /sort`: Sorts an array based on query parameters.
- `POST /sort`: Sorts an array based on the provided request body.

### Data Models
- **SortRequest**: Represents the request payload for sorting.
    - `array`: The array to be sorted.
    - `algorithm`: The sorting algorithm to use.

### Configuration Classes
- **WebInitializer**: Configures the web application.
- **WebMvcConfig**: Configures Spring MVC for the application.

### JSP Pages
1. **Sorting Form Page**: Contains the form for inputting the array and selecting the sorting algorithm.
2. **Sorting Result Page**: Displays the sorted array result.

### Glossary
- **API**: Application Programming Interface
- **HATEOAS**: Hypermedia as the Engine of Application State

## Future Enhancements
- **Additional Algorithms**: Add more sorting algorithms as needed.

---
