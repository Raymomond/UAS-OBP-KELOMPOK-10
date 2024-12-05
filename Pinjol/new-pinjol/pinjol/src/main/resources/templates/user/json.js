document.getElementById('loginForm').addEventListener('submit', async function (event) {
    event.preventDefault(); // Mencegah reload halaman

    // Ambil nilai dari form
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Kirim permintaan ke backend
    const response = await fetch('/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: new URLSearchParams({ username, password }),
    });

    // Cek apakah ada error
    if (!response.ok) {
        const result = await response.json(); // Ambil pesan error dari backend
        document.getElementById('errorMessage').innerText = result.error; // Tampilkan pesan error
    } else {
        // Jika login berhasil, redirect pengguna
        window.location.href = '/user/dashboard'; // Atur sesuai kebutuhan
    }
});
