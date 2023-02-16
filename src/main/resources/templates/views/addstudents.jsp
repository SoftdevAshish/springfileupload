<html
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
                <form role="form" th:action="@{/add}" th:object="${studentDetails}"  method="post" enctype="multipart/form-data">
                    <div class=" my-2 ">
                        <label class="form-label" for="name">Full Name</label>
                        <input type="text" id="name" th:name="name" class="form-control" th:attr="field='name'" placeholder="Enter Your Name."/>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="profilePicture">Choose Your Profile Picture</label>
                        <input type="file" id="profilePicture" th:name="profilePicture" class="form-control" th:attr="field='profilePicture'"/>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="address">Faculty</label>
                        <select class="form-select" aria-label="Default select example" th:name="faculty" th:attr="field='faculty'">
                            <optgroup label="Information Technology">
                                <option value="1">BIM</option>
                                <option value="2">BCA</option>
                                <option value="3">BSc.CSIT</option>
                            </optgroup>
                            <optgroup label="Management">
                                <option  value="4">BBS</option>
                                <option value="5">BBA</option>
                                <option value="6">BA</option>
                            </optgroup>
                        </select>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="address">Address</label>
                        <input type="text" id="address" th:name="address" class="form-control" th:attr="field='address'" placeholder="Enter Your  Address"/>
                    </div>
                    <div class=" my-2 ">
                        <label class="form-label" for="contact">Contact</label>
                        <input type="text" id="contact" th:name="contact" class="form-control" th:attr="field='contact'" placeholder="Enter Your Contact Number with Country code."/>
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