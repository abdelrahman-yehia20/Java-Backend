<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Update Item</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <style>
/* Base styles */
* {
    margin: 0;
    padding: 0;
    outline: none;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body {
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    padding: 40px;
    background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

/* Container */
.container {
    max-width: 700px;
    width: 100%;
    background: rgba(255, 255, 255, 0.95);
    padding: 40px 50px;
    border-radius: 20px;
    box-shadow: 0 15px 50px rgba(0, 0, 0, 0.2);
    backdrop-filter: blur(10px);
    position: relative;
    overflow: hidden;
    animation: fadeInUp 0.6s ease-out;
}

.container::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 5px;
    background: linear-gradient(90deg, #71b7e6, #9b59b6);
}

/* Heading */
.text {
    font-size: 3rem;
    font-weight: 700;
    text-align: center;
    background: linear-gradient(45deg, #71b7e6, #9b59b6);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    margin-bottom: 50px;
}

/* Form */
.form-row {
    display: flex;
    gap: 30px;
    margin-bottom: 40px;
    flex-wrap: wrap;
}

.input-data {
    width: 100%;
    height: 70px;
    position: relative;
    flex: 1;
    min-width: 200px;
    opacity: 0;
    animation: fadeInUp 0.6s ease-out forwards;
}

.form-row .input-data:nth-child(1) { animation-delay: 0.1s; }
.form-row .input-data:nth-child(2) { animation-delay: 0.2s; }
.form-row .input-data:nth-child(3) { animation-delay: 0.3s; }

/* Inputs */
.input-data input {
    width: 100%;
    height: 100%;
    border: none;
    background: transparent;
    font-size: 1.1rem;
    padding-top: 15px;
    border-bottom: 2px solid rgba(0,0,0,0.12);
}

.input-data input:focus ~ label,
.input-data input:valid ~ label {
    transform: translateY(-35px);
    font-size: 0.95rem;
    color: #3498db;
}

.input-data label {
    position: absolute;
    bottom: 25px;
    left: 0;
    font-size: 1.1rem;
    color: #666;
    transition: all 0.3s ease;
    pointer-events: none;
}

/* Underline */
.underline {
    position: absolute;
    bottom: 0;
    height: 2px;
    width: 100%;
    background: rgba(0,0,0,0.12);
}

.underline::before {
    content: "";
    position: absolute;
    width: 100%;
    height: 100%;
    background: linear-gradient(90deg, #71b7e6, #9b59b6);
    transform: scaleX(0);
    transition: transform 0.3s ease;
}

.input-data input:focus ~ .underline::before,
.input-data input:valid ~ .underline::before {
    transform: scaleX(1);
}

/* Readonly ID */
.input-data input[readonly] {
    color: #999;
    cursor: not-allowed;
}

/* Button */
.button {
    display: block;
    margin: 60px auto 40px;
    padding: 18px 30px;
    width: 100%;
    max-width: 300px;
    border: none;
    border-radius: 50px;
    font-size: 1.2rem;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
    background: linear-gradient(45deg, #71b7e6, #9b59b6);
    box-shadow: 0 10px 30px rgba(113,183,230,0.4);
    transition: all 0.4s ease;
    animation: fadeInUp 0.6s ease-out 0.4s forwards;
    opacity: 0;
}

.button:hover {
    transform: translateY(-3px);
    box-shadow: 0 15px 40px rgba(113,183,230,0.6);
}

/* Back link */
.back {
    text-align: center;
    animation: fadeInUp 0.6s ease-out 0.5s forwards;
    opacity: 0;
}

.back a {
    color: #666;
    text-decoration: none;
    font-size: 1.1rem;
}

.back a:hover {
    color: #3498db;
}

/* Animations */
@keyframes fadeInUp {
    from { opacity: 0; transform: translateY(20px); }
    to { opacity: 1; transform: translateY(0); }
}

/* Responsive */
@media (max-width: 700px) {
    .form-row {
        flex-direction: column;
    }
    .text {
        font-size: 2.2rem;
    }
}
  </style>
</head>

<body>
<div class="container">
  <div class="text">Update Item</div>

  <form action="/item-service-909/ItemController" method ="post">
    <div class="form-row">
      <div class="input-data">
        <input type="number" name="id" value="${item.id}" required readonly>
        <div class="underline"></div>
        <label>ID</label>
      </div>

      <div class="input-data">
        <input type="text" name="name" value="${item.name}" required>
        <div class="underline"></div>
        <label>Name</label>
      </div>

      <div class="input-data">
        <input type="number" name="price" value="${item.price}" required>
        <div class="underline"></div>
        <label>PRICE</label>
      </div>
    </div>

    <div class="form-row">
      <div class="input-data">
        <input type="number" name="totalNumber" value="${item.totalNumber}" required>
        <div class="underline"></div>
        <label>TOTAL_NUMBER</label>
      </div>
    </div>

    <input type="hidden" name="action" value="update-item">
    <input type="submit" value="Update" class="button">
  </form>

  <p class="back">
    <a href="/item-service-909/ItemController" >Back To Items</a>
  </p>
</div>
</body>
</html>
