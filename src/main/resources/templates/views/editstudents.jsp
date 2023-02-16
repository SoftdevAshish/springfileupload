<html   xmlns="http://www.w3.org/1999/xhtml"
        xmlns:th="https://www.thymeleaf.org"
        xmlns:layout="https://www.ultraq.net.nz/thymeleaf/layout"
        layout:decorate="~{layout}">
    <title >Add Student Details</title>

<section layout:fragment="body">
    <div class="container">
        <div class="row">
            <div class="col my-2">

            </div>
        </div>
        <div class="row">
            <div class="col-6 ">
                <form role="form" th:action="@{/update}" th:object="${student}"  method="post" enctype="multipart/form-data">
                    <div class=" my-2  hidden">
                        <input type="text" hidden="hidden" id="id" th:name="id"  class="form-control" th:attr="field='*{id}'" th:value="${student.id}" placeholder="Enter Your Name."/>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="name">Full Name</label>
                        <input type="text" id="name" th:name="name"  class="form-control" th:attr="field='*{name}'" th:value="${student.name}" placeholder="Enter Your Name."/>
                    </div>
                    <div class=" my-2  text-center">
                        <img th:src="@{/{img}(img=${student.profilePicture})}" th:alt="${student.name}" style="height: 20vh"/>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="profilePicture">Choose Your Profile Picture</label>
                        <input type="file" id="profilePicture" th:name="profilePicture" class="form-control" th:attr="field='profilePicture'"/>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="address">Faculty</label>
                        <select  class="form-select" aria-label="Default select example" th:name="faculty"  th:attr="field='faculty'">
                            <optgroup label="Information Technology">
                                <option th:selected="${student.faculty == '1'}" value="BIM">BIM</option>
                                <option th:selected="${student.faculty == '2'}" value="BCA">BCA</option>
                                <option  th:selected="${student.faculty == '3'}" value="BSc. CSIT">BSc.CSIT</option>
                            </optgroup>
                            <optgroup label="Management">
                                <option   th:selected="${student.faculty == '4'}" value="BBS">BBS</option>
                                <option  th:selected="${student.faculty == '5'}" value="BBA">BBA</option>
                                <option  th:selected="${student.faculty == '6'}" value="BA">BA</option>
                            </optgroup>
                        </select>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="address">Address</label>
                        <input type="text" id="address" th:name="address" class="form-control" th:attr="field='address'" th:value="${student.address}"  placeholder="Enter Your  Address"/>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="contact">Contact</label>
                        <input type="text" id="contact" th:name="contact" class="form-control" th:attr="field='contact'" th:value="${student.contact}"  placeholder="Enter Your Contact Number with Country code."/>
                    </div>

                    <div class=" my-2 text-center">
                        <input type="submit" id="btn" class="btn btn-outline-primary"  />
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

</html>