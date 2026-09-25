let districts=[]; let selectedDistrict=null; let lastScenario=null;

async function api(url, options){
  const res=await fetch(url, options);
  if(!res.ok) throw new Error("API error "+res.status);
  return res.json();
}

function showTab(name){
  document.querySelectorAll(".panel").forEach(p=>p.classList.toggle("active",p.id===name));
  document.querySelectorAll(".tab").forEach(b=>b.classList.toggle("active",b.dataset.tab===name));
}
document.querySelectorAll(".tab").forEach(b=>b.addEventListener("click",()=>showTab(b.dataset.tab)));

async function loadEvidence(){
  const items=await api("/api/evidence");
  document.getElementById("evidence-list").innerHTML=items.map(e=>`
    <article class="evidence-card">
      <h3>${e.title}</h3>
      <div class="meta">${e.source} • ${e.datePublished} • ${e.type} • ${e.strength} evidence</div>
      <p>${e.summary}</p>
    </article>`).join("");
}

async function loadDistricts(){
  districts=await api("/api/districts");
  document.getElementById("districts").innerHTML=districts.map(d=>`
    <button class="district-btn" onclick="selectDistrict(${d.id})">
      <b>${d.name}</b><span>${d.state} • climate vulnerability ${d.climateVulnerability}/100</span>
    </button>`).join("");
}
function selectDistrict(id){
  selectedDistrict=districts.find(d=>d.id===id);
  const d=selectedDistrict;
  document.getElementById("district-detail").innerHTML=`
    <div class="kicker">SELECTED DISTRICT</div>
    <h2>${d.name}, ${d.state}</h2>
    <p class="meta">Illustrative normalized indicators for the demo.</p>
    <div class="metric-grid">
      <div class="metric"><b>${d.urbanPressure}</b><span>Urban pressure</span></div>
      <div class="metric"><b>${d.agriculturalSensitivity}</b><span>Agricultural sensitivity</span></div>
      <div class="metric"><b>${d.climateVulnerability}</b><span>Climate vulnerability</span></div>
      <div class="metric"><b>${d.infrastructureOpportunity}</b><span>Infrastructure opportunity</span></div>
    </div>`;
  document.getElementById("brief-geo").textContent=`${d.name}, ${d.state} — urban pressure ${d.urbanPressure}/100, agricultural sensitivity ${d.agriculturalSensitivity}/100, climate vulnerability ${d.climateVulnerability}/100.`;
}
async function runScenario(){
  const urban=Number(document.getElementById("urban").value);
  const agri=Number(document.getElementById("agri").value);
  const result=await api("/api/scenarios/compare",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({urbanGrowthControl:urban,agriculturalProtection:agri})});
  lastScenario=result;
  document.getElementById("scenario-result").innerHTML=`
    <div class="kicker">SCENARIO RESULT</div>
    <h2>Policy trade-off profile</h2>
    <div class="score-row">
      <div><span>Development</span><b>${result.developmentScore}</b></div>
      <div><span>Resilience</span><b>${result.resilienceScore}</b></div>
      <div><span>Land pressure</span><b>${result.landPressure}</b></div>
    </div>
    <p>${result.interpretation}</p>`;
  document.getElementById("brief-scenario").textContent=`Urban growth control ${urban}/100; agricultural protection ${agri}/100. Resilience ${result.resilienceScore}, development ${result.developmentScore}, land pressure ${result.landPressure}.`;
}
function syncSliders(){
  document.getElementById("urbanOut").textContent=document.getElementById("urban").value;
  document.getElementById("agriOut").textContent=document.getElementById("agri").value;
}
document.getElementById("urban").addEventListener("input",syncSliders);
document.getElementById("agri").addEventListener("input",syncSliders);

function analyze(){
  document.getElementById("brief-question").textContent=document.getElementById("question").value;
  showTab("evidence");
}
document.getElementById("brief-question").textContent=document.getElementById("question").value;

Promise.all([loadEvidence(),loadDistricts(),runScenario()]).catch(err=>{
  document.body.insertAdjacentHTML("afterbegin",`<div style="background:#fff0f0;color:#7a1d1d;padding:12px;text-align:center">Backend connection error: ${err.message}</div>`);
});
