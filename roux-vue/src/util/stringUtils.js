export function hashString(input) {
    var hash = 0, i, chr;
    for (i = 0; i < input.length; i++) {
        chr   = input.charCodeAt(i);
        hash  = ((hash << 5) - hash) + chr;
        hash |= 0; // Convert to 32bit integer
    }
    return Math.abs(hash);
};