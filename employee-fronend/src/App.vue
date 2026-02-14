<template>
  <div class="container">
    <h1>Employee Management</h1>

    <div class="form-card">
      <input v-model="empId" placeholder="Employee ID" />
      <input v-model="name" placeholder="Employee Name" />
      <button @click="addEmployee">Add Employee</button>
    </div>

    <div class="table-card">
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Employee ID</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="emp in employees" :key="emp.id">
            <td>{{ emp.id }}</td>
            <td>{{ emp.empId }}</td>
            <td>{{ emp.name }}</td>
          </tr>
        </tbody>
      </table>

      <p v-if="employees.length === 0" class="no-data">
        No Employees Found
      </p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      employees: [],
      empId: "",
      name: ""
    };
  },
  mounted() {
    this.fetchEmployees();
  },
  methods: {
    fetchEmployees() {
      axios.get("http://localhost:8080/api/employees")
        .then(response => {
          this.employees = response.data;
        });
    },
    addEmployee() {
      if (!this.empId || !this.name) {
        alert("Please fill all fields");
        return;
      }

      axios.post("http://localhost:8080/api/employees", {
        empId: this.empId,
        name: this.name
      }).then(() => {
        this.empId = "";
        this.name = "";
        this.fetchEmployees();
      });
    }
  }
};
</script>

<style>
body {
  margin: 0;
  font-family: Arial, sans-serif;
  background: linear-gradient(135deg, #4e73df, #1cc88a);
}

.container {
  max-width: 900px;
  margin: 40px auto;
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 8px 20px rgba(0,0,0,0.2);
}

h1 {
  text-align: center;
  color: #4e73df;
}

.form-card {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}

input {
  padding: 10px;
  border-radius: 6px;
  border: 1px solid #ccc;
  flex: 1;
}

button {
  padding: 10px 20px;
  border: none;
  background-color: #1cc88a;
  color: white;
  border-radius: 6px;
  cursor: pointer;
  font-weight: bold;
}

button:hover {
  background-color: #17a673;
}

.table-card {
  margin-top: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th {
  background-color: #4e73df;
  color: white;
  padding: 10px;
}

td {
  padding: 10px;
  text-align: center;
  border-bottom: 1px solid #ddd;
}

tr:hover {
  background-color: #f2f2f2;
}

.no-data {
  text-align: center;
  color: gray;
  margin-top: 15px;
}
</style>
