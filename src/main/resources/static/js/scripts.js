document.addEventListener("DOMContentLoaded", () => {
  const themeToggle = document.getElementById("themeToggle");
  const body = document.body;

  function setTheme(dark) {
    if (dark) {
      body.classList.add("dark-mode");
      if (themeToggle) themeToggle.textContent = "☀️ Light";
      localStorage.setItem("theme", "dark");
    } else {
      body.classList.remove("dark-mode");
      if (themeToggle) themeToggle.textContent = "🌙 Dark";
      localStorage.setItem("theme", "light");
    }
  }

  // Apply stored theme
  setTheme(localStorage.getItem("theme") === "dark");

  if (themeToggle) {
    themeToggle.addEventListener("click", () => {
      const isDark = body.classList.contains("dark-mode");
      setTheme(!isDark);
    });
  }

  // Search filter (for index.html)
  const searchInput = document.getElementById("searchInput");
  if (searchInput) {
    searchInput.addEventListener("input", () => {
      const query = searchInput.value.toLowerCase();
      document.querySelectorAll(".key-card").forEach(card => {
        const text = card.textContent.toLowerCase();
        card.style.display = text.includes(query) ? "" : "none";
      });
    });
  }

  // View toggle (for index.html)
  const gridBtn = document.getElementById("gridViewBtn");
  const listBtn = document.getElementById("listViewBtn");
  const container = document.getElementById("keyContainer");

  if (gridBtn && listBtn && container) {
    gridBtn.addEventListener("click", () => {
      container.classList.remove("list-view");
      gridBtn.classList.add("active");
      listBtn.classList.remove("active");
    });
    listBtn.addEventListener("click", () => {
      container.classList.add("list-view");
      listBtn.classList.add("active");
      gridBtn.classList.remove("active");
    });
  }

  // Edit page: Signature field toggle
  const statusField = document.getElementById("status");
  const signatureContainer = document.getElementById("signature-container");

  if (statusField && signatureContainer) {
    statusField.addEventListener("change", () => {
      signatureContainer.classList.toggle("d-none", statusField.value !== "Issued");
    });
    statusField.dispatchEvent(new Event("change"));
  }

  // Signature pad logic (edit.html only)
  const canvas = document.getElementById("signature-pad");
  if (canvas) {
    const ctx = canvas.getContext("2d");
    let drawing = false;

    canvas.addEventListener("mousedown", () => (drawing = true));
    canvas.addEventListener("mouseup", () => {
      drawing = false;
      ctx.beginPath();
    });
    canvas.addEventListener("mouseleave", () => {
      drawing = false;
      ctx.beginPath();
    });
    canvas.addEventListener("mousemove", (e) => {
      if (!drawing) return;
      ctx.lineWidth = 2;
      ctx.lineCap = "round";
      ctx.strokeStyle = "#000";
      const rect = canvas.getBoundingClientRect();
      ctx.lineTo(e.clientX - rect.left, e.clientY - rect.top);
      ctx.stroke();
    });

    const clearBtn = document.getElementById("clear-signature");
    clearBtn?.addEventListener("click", () => {
      ctx.clearRect(0, 0, canvas.width, canvas.height);
    });
  }
});
