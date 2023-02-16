<html
        xmlns:th="https://www.thymeleaf.org"
        xmlns:layout="https://www.ultraq.net.nz/thymeleaf/layout"
        layout:decorate="~{layout}">
<section layout:fragment="body">
    <div class="container">
        <div class="row">
            <div class="col my-2">
                <a th:href="@{/addstudent}" class="btn btn-outline-info"> Add Students</a>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <table class="table align-middle mb-0 bg-white">
                    <thead class="bg-light">
                    <tr class="text-center">
                        <th>Full Name</th>
                        <th>Faculty</th>
                        <th>Address</th>
                        <th>Contact Number</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="text-center" th:each="student : ${students}">
                        <td>
                            <div class="d-flex align-items-center">
                                <img th:src="${student.profilePicture}" th:alt="${student.name}" style="width: 45px; height: 45px" class="rounded-circle"/>
                                <div class="ms-3">
                                    <p class="fw-bold" th:text="${student.name}"></p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="fw-normal" th:text="${student.faculty}"></p>
                        </td>
                        <td>
                            <p class="fw-normal" th:text="${student.address}"></p>
                        </td>
                        <td>
                            <p class="fw-normal" th:text="${student.contact}"></p>
                        </td>
                        <td>
                            <a th:href="@{/edit/{id}(id=${student.id})}">Edit</a>
                            <a th:href="@{/delete/{id}(id=${student.id})}">Delete</a>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

</html>